package com.cambodia.udemy.project.service.imp;

import com.cambodia.udemy.project.dto.request.UsersRequest;
import com.cambodia.udemy.project.dto.response.ApiResponse;
import com.cambodia.udemy.project.dto.response.UsersResponse;
import com.cambodia.udemy.project.entity.Users;
import com.cambodia.udemy.project.exception.CustomBadRequestException;
import com.cambodia.udemy.project.mapper.UsersMapper;
import com.cambodia.udemy.project.repository.UserRepository;
import com.cambodia.udemy.project.service.UserServices;
import com.cambodia.udemy.project.utils.MessageResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImp implements UserServices {

    @Autowired
    private UserRepository userRepository;
    private static final UsersMapper userMapper = Mappers.getMapper(UsersMapper.class);
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    public String emailSender;

    @Override
    public ApiResponse<String> createUser(UsersRequest usersRequest) throws MessagingException, UnsupportedEncodingException {
        Users users = userMapper.mapToUsers(usersRequest);
        users.setJoinDate(LocalDate.now());

        String randomCode = RandomStringUtils.random(64);

        users.setVerificationCode(randomCode);
        users.setVerify(false);

        userRepository.save(users);
        log.info("success create user: {}", usersRequest.getUsername());
        sendEmailVerification(users);

        return new ApiResponse<>(HttpStatus.CREATED.value(), MessageResponse.SUCCESS_CREATED_USER, MessageResponse.MESSAGE_SUCCESS);
    }

    @Override
    public ApiResponse<?> getAllUser() {
        List<Users> users = userRepository.findAll();
        log.info("get all users success!");

        List<UsersResponse> usersResponses = users.stream()
                .map(userMapper::mapToUsersResponse)
                .collect(Collectors.toList());

        return new ApiResponse<>(HttpStatus.OK.value(), MessageResponse.MESSAGE_SUCCESS, usersResponses);
    }

    private void sendEmailVerification(Users request) throws MessagingException, UnsupportedEncodingException {
        String toEmailAddress = request.getEmail();
        String senderName = "From E-Learning Platform";
        String subject = "Please verify your registration!";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank You,<br>"
                + "Kompheak E-Learning.";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(emailSender, senderName);
            helper.setTo(toEmailAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", request.getUsername());
            String verifyCode = "/verify?code=" + request.getVerificationCode();
            content = content.replace("[[URL]]", verifyCode);
            helper.setText(content, true);

            mailSender.send(message);
        }catch (Exception e){
            log.error("error when send email verification!");
            throw new CustomBadRequestException("cannot create this user!");
        }
    }
}
