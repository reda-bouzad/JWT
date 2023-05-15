package maroc.reda.jwt.service;

import maroc.reda.jwt.dao.UserDao;
import maroc.reda.jwt.entity.Role;
import maroc.reda.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    public User registerNewUser(User user){
        return userDao.save(user);
    }

    public void initRolesAndUser(){

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        roleService.createNewRole(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        roleService.createNewRole(userRole);

        User adminUser = new User();
        adminUser.setUserName("DarkS00l");
        adminUser.setFirstName("Reda");
        adminUser.setLastName("Bouzad");
        adminUser.setPassword("admin123");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        //adminUser.setRoles(adminRoles);
        userDao.save(adminUser);


        User normalUser = new User();
        normalUser.setUserName("Gabriole");
        normalUser.setFirstName("Ismail");
        normalUser.setLastName("Mouhtram");
        normalUser.setPassword("user123");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        //normalUser.setRoles(userRoles);
        userDao.save(normalUser);


    }
}
