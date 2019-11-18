package com.xcy.controller;

import com.xcy.domain.XcyUser;
import com.xcy.repository.XcyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/xcyUser")
public class XcyUserController {
    @Autowired
    private XcyUserRepository xcyUserRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> findAll(XcyUser entity,
                                     @PageableDefault(value = 10, sort = {"id"}, direction = Sort.Direction.DESC)
                                             Pageable pageable) {

        Example<XcyUser> example = Example.of(entity);
        Page<XcyUser> apply = this.xcyUserRepository.findAll(example, pageable);
        return new ResponseEntity<>(apply, HttpStatus.OK);
    }

}

