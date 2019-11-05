package top.xuxuzhaozhao.service.impl;

import org.springframework.stereotype.Component;
import top.xuxuzhaozhao.service.IAccountService;

@Component
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
        int i = 12;
        int x = i / 0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了修改：" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
