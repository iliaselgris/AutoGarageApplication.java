package com.example.auto_garage.controller;

import com.example.auto_garage.model.employee.User;
import com.example.auto_garage.repository.UserRepository;
import com.example.auto_garage.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("index")
//    public String home() {
//        return ("<h1>Welcome</h1>");
//    }
//
    @PreAuthorize("hasAnyRole('MONTEUR','FRONTDESK')")
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }



    // display list of Users
    @GetMapping(value = "")
//    public ResponseEntity<Object> viewHomePage(Model model) {
////        return findPaginated(1, "firstName", "asc", model);
//        return ResponseEntity.ok().body(userService.getAllUsers());
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }



    @GetMapping(value = "/{id}")
            public ResponseEntity<Object> getUSER(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userRepository.findById(id));
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.saveUser(user);
        return "redirect:/";
    }

    @PutMapping(value = "/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get user from the service
        User user = userService.getUserById(id);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUser = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUser", listUser);
        return "index";
    }
}



