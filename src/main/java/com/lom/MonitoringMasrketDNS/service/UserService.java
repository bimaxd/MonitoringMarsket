package com.lom.MonitoringMasrketDNS.service;

import com.lom.MonitoringMasrketDNS.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(long userId);

    public User getUserById(long id);

    public List<User> getAllUsers();
}
