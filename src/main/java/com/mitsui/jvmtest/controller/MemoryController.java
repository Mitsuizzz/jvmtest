package com.mitsui.jvmtest.controller;

import com.mitsui.jvmtest.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: jvmtest
 * @description:内存溢出例子
 * @author: mitsuizzz
 * @create: 2021-05-20 14:33
 **/
@RestController
public class MemoryController {
    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<Class<?>>();

    /**演示堆内存溢出
     * -Xmx 32M  -Xms 32M
     * @return
     */
    @GetMapping("/heap")
    public String heap(){
        int i = 0;
        while (true){
            System.out.println("当前次数："+i);
            userList.add(new User(i++,UUID.randomUUID().toString()));
        }
    }

    /**演示非堆内存溢出  mataspace
     * -Xmx 32M  -Xms 32M
     * @return
     */
    @GetMapping("/noheap")
    public String noheap(){
        int i = 0;
        while (true){
            System.out.println("当前次数："+i);
//            classList.addAll();
        }
    }
}
