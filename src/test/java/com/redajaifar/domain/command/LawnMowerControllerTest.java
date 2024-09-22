package com.redajaifar.domain.command;

import com.redajaifar.domain.model.Instruction;
import com.redajaifar.domain.model.Lawn;
import com.redajaifar.domain.model.Mower;
import com.redajaifar.domain.model.Orientation;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerControllerTest {

    private LawnMowerController lawnMowerController = new LawnMowerController();

    @Test
    void mow() {

        // Define Lawn
        Lawn lawn = new Lawn(5, 5);

        // Define Mower
        Mower mower = new Mower(new AbstractMap.SimpleEntry<>(1, 2), Orientation.N);

        // Define Instructions
        List<Instruction> instructions = Arrays.asList(
                Instruction.G,
                Instruction.A,
                Instruction.G,
                Instruction.A,
                Instruction.G,
                Instruction.A,
                Instruction.G,
                Instruction.A,
                Instruction.A
        );

        // Mow and get the instructed mower
        Mower instructedMower = lawnMowerController.mow(lawn, mower, instructions);

        // Assert result
        assertEquals(instructedMower, new Mower(new AbstractMap.SimpleEntry<>(1, 3), Orientation.N));
    }
}
