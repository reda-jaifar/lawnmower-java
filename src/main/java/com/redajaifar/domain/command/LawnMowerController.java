package com.redajaifar.domain.command;

import com.redajaifar.domain.model.Instruction;
import com.redajaifar.domain.model.Lawn;
import com.redajaifar.domain.model.Mower;
import com.redajaifar.domain.model.Orientation;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LawnMowerController {

    static Map<Orientation, AbstractMap.SimpleEntry<Integer, Integer>> movements = new HashMap<>() {{
        put(Orientation.N, new AbstractMap.SimpleEntry<>(0, 1));   // Move north (y increases)
        put(Orientation.E, new AbstractMap.SimpleEntry<>(1, 0));   // Move east (x increases)
        put(Orientation.S, new AbstractMap.SimpleEntry<>(0, -1));  // Move south (y decreases)
        put(Orientation.W, new AbstractMap.SimpleEntry<>(-1, 0));  // Move west (x decreases)
    }};


    public Mower mow(Lawn lawn, Mower mower, List<Instruction> instructions) {
        int maxX = lawn.getX();
        int maxY = lawn.getY();

        int x = mower.getPosition().getKey();
        int y = mower.getPosition().getValue();
        Orientation orientation = mower.getOrientation();

        Orientation[] directions = Orientation.values();

        // Process each instruction in the instructions list
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case G: {
                    // Turn left (counter-clockwise)
                    orientation = directions[(indexOf(directions, orientation) - 1 + 4) % 4];
                    break;
                }
                case D: {
                    // Turn right (clockwise)
                    orientation = directions[(indexOf(directions, orientation) + 1) % 4];
                    break;
                }
                case A: {
                    // Move forward in the current direction
                    AbstractMap.SimpleEntry<Integer, Integer> move = LawnMowerController.movements.get(orientation);
                    int newX = x + move.getKey();
                    int newY = y + move.getValue();

                    // Ensure the mower stays within grid bounds
                    if (newX >= 0 && newX <= maxX && newY >= 0 && newY <= maxY) {
                        x = newX;
                        y = newY;
                    }
                    break;
                }
            }
        }
        return new Mower(new AbstractMap.SimpleEntry<>(x, y), orientation);
    }

    private int indexOf(Orientation[] array, Orientation value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // Not found
    }


}
