package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
             User user = findByPassport(passport);
              List<Account> list;
              list = users.get(user);
            if (!list.contains(account)) {
                users.get(user).add(account);
            }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User key: users.keySet()) {
               if (key.getPassport().equals(passport)) {
                    rsl = key;
                    break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user;
        Account rsl = null;
        List<Account> list;
            user = findByPassport(passport);
             if (nonNull(user)) {
                 list = users.get(user);
                 for (Account account : list) {
                     if (account.getRequisite().equals(requisite)) {
                         rsl = account;
                     }
                 }
             }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User userSource = findByPassport(srcPassport);
        Account source = findByRequisite(srcPassport, srcRequisite);
        User userDest = findByPassport(destPassport);
        Account dest = findByRequisite(destPassport, destRequisite);
         List<Account> listDest;
        List<Account> listSource;

        double balanceSource = source.getBalance();
        if (balanceSource >= amount) {
            double balanceDest = dest.getBalance();
            listDest = users.get(userDest);
            listSource = users.get(userSource);
                dest.setBalance(balanceDest + amount);
                source.setBalance(balanceSource - amount);

                listDest.set(listDest.indexOf(dest), dest);
                listSource.set(listSource.indexOf(source), source);

                users.putIfAbsent(userDest, listDest);
                users.putIfAbsent(userSource, listSource);
                rsl = true;
            }
        return rsl;
    }
}