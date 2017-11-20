package com.microservice.erp2017.service;

/**
 *
 * @author reza
 */
public interface EmailService {
    void sendEmail(String activationCode, String email);
}
