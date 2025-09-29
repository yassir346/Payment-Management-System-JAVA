package service;

import models.Agent;

import java.sql.SQLException;

public interface IAuthService {
    Agent login(String email, String password) throws SQLException;
}
