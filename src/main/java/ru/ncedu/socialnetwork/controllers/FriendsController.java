package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.domain.FriendId;
import ru.ncedu.socialnetwork.domain.FriendsDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.FriendsRepository;
import ru.ncedu.socialnetwork.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendsController {
    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<FriendsDAO> getAll(@AuthenticationPrincipal UserDAO userDAO){

        List<FriendsDAO> friendsDAO = new ArrayList<>();
        if(friendsRepository.findAll().isEmpty()) {
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 0), "https://pbs.twimg.com/profile_images/787106179482869760/CwwG2e2M_400x400.jpg", "Vladimir Tryapochkin", userDAO.getLogin(), true));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 1), "https://avatarfiles.alphacoders.com/101/101019.jpg", "Ruslan Kirpichev", userDAO.getLogin(), false));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 2), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5BjsOEx8xm62e7l8cDptKshlPEj32WAVGdC0G4bo-FaSu-n8M", "Anatoluy Kolpakov", "Login hardcode", true));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 3), "https://avatarfiles.alphacoders.com/774/77499.jpg", "Vasily Nemoy", userDAO.getLogin(), true));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 4), "https://avatarko.ru/img/kartinka/4/uzhasy_kloun_3127.jpg", "Pavel Stropal'", userDAO.getLogin(), false));

            friendsRepository.save(friendsDAO);
        }
        return friendsRepository.findAllByFriendIdUserId(userDAO.getUserId());
    }

    @PostMapping(value = "{name}")
    public void addFriend(@AuthenticationPrincipal UserDAO userDAO, @PathVariable String name) {
        UserDAO newFriend = userRepository.findByLogin(name);
        FriendsDAO newFriendDAO = new FriendsDAO(new FriendId(userDAO.getUserId(), newFriend.getUserId()), newFriend.getImagePath(), newFriend.getName(), newFriend.getLogin(), false);
        friendsRepository.save(newFriendDAO);

    }

    @DeleteMapping(value = "{id}")
    public void removeFriend(@AuthenticationPrincipal UserDAO userDAO, @PathVariable int id) {
        friendsRepository.delete(new FriendId(userDAO.getUserId(), id));
    }
}
