package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описыывает модель банковской системы
 */
public class BankService {
    /**
     * Поле Map хранит клиентов и список их счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет клиентов в поле users и создает пустой список счетов если клиента нет в базе
     * @param user - клиент банка
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * добавляет новый счет клиенту
     * @param passport - паспортные данные
     * @param account - номер аккаунта
     */
    public void addAccount(String passport, Account account) {
             User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * ищет клиента по паспортным данным
     * @param passport - паспортные данные
     * @return возвращает клиента или null если таквоого нет в базе
     */
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

    /**
     * ищет номер счета по реквизитам
     * @param passport - паспортные данные клиента
     * @param requisite реквизиты счета клиента
     * @return возвращает либо номер счета либо null если такого нет в базе
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * перечисляет деньги со счета одного клиента на счет другого
     * @param srcPassport - паспорт клиент отправляющего деньги
     * @param srcRequisite - реквзиты счета клиента отправляющего деньги
     * @param destPassport - паспортные данные клиента получающего деньги
     * @param destRequisite - реквизиты счета клиента получающего деньги
     * @param amount - величина пересляемых средств
     * @return возвращает true если операция проходит успешно
     * либо false если нету счета у одного из клиентов или
     * денег на счету клиента недостаточно для перечисления
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account source = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        double balanceSource = source.getBalance();
        if (source != null && dest != null && source.getBalance() >= amount) {
            double balanceDest = dest.getBalance();
                dest.setBalance(balanceDest + amount);
                source.setBalance(balanceSource - amount);
                rsl = true;
            }
        return rsl;
    }
}