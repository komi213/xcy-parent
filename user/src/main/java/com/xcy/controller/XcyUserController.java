package com.xcy.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    /**
     * @api {POST} /xcyUser  用户添加
     * @apiGroup xcy-user-server
     * @apiVersion 0.0.1
     * @apiDescription 用户添加
     * @apiParam {String} name 姓名
     * @apiParam {String} age 年龄
     * @apiParamExample {json} 请求样例：
     * /xcyUser
     * @apiSuccess (200) {String} message 信息
     * @apiSuccessExample {json} 成功:
     * {"message":"成功"}
     * @apiSuccessExample {json} 失败:
     * {"message":"失败"}
     */
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> post(XcyUser entity) {
        JSONObject returnJsonObject = new JSONObject();

        XcyUser queryNewsCate = new XcyUser();
        queryNewsCate.setName(entity.getName());
        Example<XcyUser> example = Example.of(queryNewsCate);
        List<XcyUser> all = this.xcyUserRepository.findAll(example);
        if (all.size() > 0) {
            returnJsonObject.put("message", "姓名已存在");
            return new ResponseEntity<JSONObject>(returnJsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        XcyUser c = this.xcyUserRepository.save(entity);
        if (c != null) {
            returnJsonObject.put("message", "成功");
            return new ResponseEntity<XcyUser>(c, HttpStatus.OK);
        }
        returnJsonObject.put("message", "失败");
        return new ResponseEntity<JSONObject>(returnJsonObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

