package com.uptc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.uptc.models.Process;
import com.uptc.reports.Report;

public class ControllerApp implements ActionListener {
    ExecuteProcess executeProcess;
    Report reportClass;
    public ControllerApp(){
        executeProcess = new ExecuteProcess();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case C_ADD_PROCESS:
               //agregar proceso a la tabla de procesos
               addProcessTable();
             break;
            case C_EXECUTE_PROCESS:
               //Ejecutar lista de procesos
                executeProcess();
            break;
            case C_REPORT_MISSING_TIME_PER_PROCESS:
                //reporte por tiempo faltante por proceso
                reportMissingTimeProcess();
            break;
            case C_REPORT_FOR_STATUS_CHANGE_PROCESS:
                //reporte por cambio de estado de los procesos
                reportStatusChangeProcess();
            break;
            case C_REPORT_BY_READY_STATES:
                //reporte por orden en el estado en listo
                reportByReadyStates();
            break;
            case C_REPORT_BY_EXECUTE_STATES:
                //reporte por orden en el estado de en ejecución
                reportByCpuExecuteOrder();
            break;
            case C_REPORT_BY_LOCKED_STATES:
                //reporte por orden en el estado en bloqueo
                reportByLockedStates();
            break;
            case C_REPORT_BY_EXIT_STATE:
                //reporte por orden en el estado en salida
                reportByExitState();
            break;
            case C_REPORT_FOR_STATUS_CHANGE:
                //reporte por cambios de estado de cada proceso
                reportForStatusChange();
            break;

                default:
                break;
        }              
    }  


    public void addProcessTable(){

    }

    
    public void executeProcess(){
        //manageview 
        //set time
        int time=0;
        ArrayList<Object[]> listProcess = new ArrayList<>();
        //set lista de procesos
        executeListProcess(time, listProcess);
    }

    public void executeListProcess(int time,ArrayList<Object[]> listProcess){
        int timeCPU = time;
       // listProcess.forEach(x -> executeProcess.addProcessToQueue(new Process( x[0],x[1] ,x[2])));
        for (int i = 0; i < listProcess.size(); i++) {
            Object[] vector=(Object[]) listProcess.get(i);
            executeProcess.addProcessToQueue(new Process(""+vector[0], Integer.parseInt(""+vector[1]), Boolean.parseBoolean(""+vector[2])));
        }
        executeProcess.init(timeCPU);
        executeProcess.reports();
    }

    public ArrayList<Object[]> reportMissingTimeProcess(){
      /* for (int i = 0; i < executeProcess.reportMissingTimeProcess().size(); i++) {
            System.out.println(executeProcess.reportMissingTimeProcess().get(i));
        } */
        return executeProcess.reportMissingTimeProcess();
    }

    public ArrayList<String[]> reportStatusChangeProcess(){
        /* for (int i = 0; i < executeProcess.reportStatusChangeProcess().size(); i++) {
            System.out.println(executeProcess.reportStatusChangeProcess().get(i));
        } */
        return executeProcess.reportStatusChangeProcess();
    }

    public ArrayList<String[]> reportByCpuExecuteOrder(){
        return executeProcess.reportByCpuExecuteOrder();
    }

    public ArrayList<String[]> reportByReadyStates(){
        return executeProcess.reportByReadyStates();
    }

    public ArrayList<String[]> reportByLockedStates(){
        return executeProcess.reportByLockedStates();
    }

    public ArrayList<String[]> reportByExitState(){
        return executeProcess.reportByExitState();
    } 

    public ArrayList<Object[]> reportForStatusChange(){
        return executeProcess.reportForStatusChange();
    }
}
