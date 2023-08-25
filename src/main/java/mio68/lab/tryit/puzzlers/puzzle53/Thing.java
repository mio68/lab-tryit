package mio68.lab.tryit.puzzlers.puzzle53;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thing {
    private final int i;

    public Thing(int i) {
        this.i = i;
        log.info("i = {}", i);
    }
}
