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
    public List<UserDAO> getAll(@AuthenticationPrincipal UserDAO userDAO){

        List<FriendsDAO> friendsDAO = new ArrayList<>();

        if (friendsRepository.findAll().isEmpty()) {
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 1215), false));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 3), true));
            friendsDAO.add(new FriendsDAO(new FriendId(userDAO.getUserId(), 894), true));
            friendsRepository.save(friendsDAO);
            friendsDAO.clear();
        }

        List<FriendsDAO> oldFriends = friendsRepository.findAll();

        List<UserDAO> friendList = new ArrayList<>();
        for (FriendsDAO userElement: oldFriends) {
            UserDAO friend = userRepository.findByUserId(userElement.getFriendId().getId());
            if(friend != null) {
                friendList.add(friend);
            }
        }

        return friendList;
    }

    @PostMapping(value = "{login}")
    public void addFriend(@AuthenticationPrincipal UserDAO userDAO, @PathVariable String login) {
        UserDAO newFriend = userRepository.findByLogin(login);
        if(newFriend != null){
            friendsRepository.save(new FriendsDAO(new FriendId(userDAO.getUserId(), newFriend.getUserId()), true));
        }

    }

    @DeleteMapping(value = "{id}")
    public void removeFriend(@AuthenticationPrincipal UserDAO userDAO, @PathVariable int id) {
        friendsRepository.delete(new FriendId(userDAO.getUserId(), id));
    }
}
