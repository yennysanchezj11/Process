package com.uptc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Process {

    private final String name;
    private int time;
    private final boolean isLocked;

    private final Map<Integer, List<Register>> register;

    public Process(String name, int time, boolean isLocked) {
        this.name = name;
        this.time = time;
        this.isLocked = isLocked;
        // this.registers = new LinkedList<>();
        this.register = new HashMap<>();
    }

    public void states(int timeI, int timeF, States status, States previous) {
        //this.registers.add(new Register(timeI,timeF,status,this.time,this));
        Register r = new Register(timeI, timeF, status, this.time, this, previous);
        addRegister(timeI, r);
        addRegister(timeF, r);
    }

    private void addRegister(int time, Register status) {
        if (!register.containsKey(time)) register.put(time, new ArrayList<>());
        if (!register.get(time).contains(status)) register.get(time).add(status);
    }

    public int getTime() {
        return time;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setTime(int time) {
        this.time -= time;
    }

    public String getName() {
        return name;
    }

    public String[] getTableByState(int totalTime, int timeCPU) {
        String aux[] = {};
        aux[0]=name;
        for (int i = 1; i <= totalTime; i += timeCPU) {
            String status = getLastByState(i, timeCPU);
            aux[i] = status;
        }
       return aux;
    }

    public Object[] getTableByTime(int totalTime, int timeCPU) {
        Object aux[] = {};
        aux[0]=name;
        for (int i = 1; i <= totalTime; i += timeCPU) {
            int lastTime = getLastByTime(i, timeCPU);
            aux[i] = lastTime!=-1 ? lastTime : 0;
        }
        return aux;
    }

    private int getLastByTime(int initKey, int timeCPU) {
        for (int i = initKey; i > initKey - timeCPU; i--) {
            int key = i;
            Optional<Integer> actualTime = register.getOrDefault(key, List.of())
                    .stream().filter(x -> x.timeEnd == key)
                    .map(x -> x.actualTime)
                    .findFirst();
            if (actualTime.isPresent()) return actualTime.get();
        }
        return -1;
    }

    private String getLastByState(int initKey, int timeCPU) {
        StringBuilder status = new StringBuilder();
        for (int i = initKey; i > initKey - timeCPU; i--) {
            register.getOrDefault(i, List.of())
                    .stream().map(x-> x.status.toString())
                    .forEach(status::append);
        }
        return status.toString();
    }

    public List<Register> getAllRegisters(){
        List<Register> registers = new ArrayList<>();
        register.forEach((k,v)-> registers.addAll(v));
        return registers;
    }
}
