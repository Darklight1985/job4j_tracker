package ru.job4j.gc;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartUIForGC {
    private final Output out;

    public StartUIForGC(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new MemTracker()) {
            tracker.init();
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions,
                new CreateAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new ShowAllAction(output),
                new FindItemByIdAction(output),
                new FindItemByNameAction(output),
                new GCAction(output),
                new ExitAction());
            new StartUIForGC(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
