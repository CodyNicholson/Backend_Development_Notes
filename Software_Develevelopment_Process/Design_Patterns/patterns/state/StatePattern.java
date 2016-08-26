package patterns.state;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * The StatePattern for a garage door opener Based on material by Prof. David
 * Bernstein, James Madison University
 */

class Context {
    private State state;

    public Context() {
        state = Closed.enter();
    }

    public void handleEvent(String command) {
        State old = state;
        state = state.handleEvent(command);
        if (old != state) {
            System.out.println("\tChanged state to: "
                    + state.getClass().getSimpleName());
            System.out.flush();
        }
    }
}

// Abstract State
abstract class State {
    protected Context context;

    public State unhandled() {
        System.out.println("\tEvent is inconsequential in this state");
        return this;
    }

    public State handleEvent(String command) {
        Method m = null;
        State s = this;
        try {
            m = getClass().getMethod(command);
            s = (State) m.invoke(this, (Object[]) null);
        } catch (NoSuchMethodException e) {
            System.out.println("\tUnknown event");
            System.out.flush();
        } catch (IllegalArgumentException e) {
            System.out.println("\tThis shouldn't happen!");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("\tThis shouldn't happen!");
            System.exit(1);
        } catch (InvocationTargetException e) {
            System.out.println("\tThis shouldn't happen!");
            System.exit(1);
        }
        return s;
    }

    // Important: in each subclass, processing is performed based on the current
    // state, that is, the same "event" can trigger a different behavior
    // depending on the state.
    public State close() {
        return unhandled();
    }

    public State combination() {
        return unhandled();
    }

    public State error() {
        return unhandled();
    }

    public State lock() {
        return unhandled();
    }

    public State open() {
        return unhandled();
    }

    public State unlock() {
        return unhandled();
    }
}

// State: AwaitingCombination
class AwaitingCombination extends State {
    protected static State instance;

    private AwaitingCombination() {
    }

    // This gets invoked by other states
    public static State enter() {
        if (instance == null) {
            instance = new AwaitingCombination();
        }
        return instance;
    }

    // Process events (unimplemented ones are simply ignored)
    @Override
    public State combination() {
        return Closed.enter();
    }

    @Override
    public State error() {
        return Locked.enter();
    }
}

// State: Closed
class Closed extends State {
    protected static State instance;

    private Closed() {
    }

    public static State enter() {
        if (instance == null) {
            instance = new Closed();
        }
        return instance;
    }

    // Process events (unimplemented ones are simply ignored)
    @Override
    public State lock() {
        return Locked.enter();
    }

    @Override
    public State open() {
        return Opened.enter();
    }
}

// State: Locked
class Locked extends State {
    protected static State instance;

    private Locked() {
    }

    public static State enter() {
        if (instance == null) {
            instance = new Locked();
        }
        return instance;
    }

    // Process events (unimplemented ones are simply ignored)
    @Override
    public State unlock() {
        return AwaitingCombination.enter();
    }
}

// State: Opened
class Opened extends State {
    protected static State instance;

    private Opened() {
    }

    public static State enter() {
        if (instance == null) {
            instance = new Opened();
        }
        return instance;
    }

    // Process events (unimplemented ones are simply ignored)
    @Override
    public State close() {
        return Closed.enter();
    }
}

public class StatePattern {
    public static void main(String[] args) throws IOException {
        Context context = new Context();
        String command;
        Scanner scanner = new Scanner(System.in);
        System.out
                .print("Command (close,combination,error,lock,open,unlock): ");
        System.out.flush();

        while (scanner.hasNext()) {
            command = scanner.next();
            if (command.equals("exit")) {
                break;
            }
            context.handleEvent(command);
            System.out
                    .print("Command (close,combination,error,lock,open,unlock): ");
            System.out.flush();
        }
    }
}
