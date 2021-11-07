package ru.job4j.bank;

import java.util.*;

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
             Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * ищет клиента по паспортным данным
     * @param passport - паспортные данные
     * @return возвращает клиента или null если таквоого нет в базе
     */
    public Optional<User> findByPassport(String passport) {
       return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
       }

    /**
     * ищет номер счета по реквизитам
     * @param passport - паспортные данные клиента
     * @param requisite реквизиты счета клиента
     * @return возвращает либо номер счета либо null если такого нет в базе
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> source = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        double balanceSource = source.get().getBalance();
        if (source.isPresent() && dest.isPresent() && source.get().getBalance() >= amount) {
            double balanceDest = dest.get().getBalance();
                dest.get().setBalance(balanceDest + amount);
                source.get().setBalance(balanceSource - amount);
                rsl = true;
            }
        return rsl;
    }
}