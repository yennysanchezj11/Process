package com.uptc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.uptc.models.Process;
import com.uptc.reports.Report;
import com.uptc.viewer.JFramePrincipal;

public class ControllerApp implements ActionListener {
    ExecuteProcess executeProcess;
    JFramePrincipal jPrincipal;
    Report reportClass;
    static PrintWriter printWriter = new PrintWriter(System.out);

    public ControllerApp() {
        executeProcess = new ExecuteProcess();
        jPrincipal = new JFramePrincipal(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Commands.valueOf(e.getActionCommand())) {
            case C_ADD_PROCESS:
                // agregar proceso a la tabla de procesos
                addProcessTable();

                break;
            case C_REPORTS_VIEW:
                // Ejecutar lista de procesos
                reportview();
                break;
            case C_EXECUTE_PROCESS:
                // Ejecutar lista de procesos
                executeProcess();
                break;
            case C_REPORT_MISSING_TIME_PER_PROCESS:
                // reporte por tiempo faltante por proceso
                // reportMissingTimeProcess();
                // jPrincipal.dialogVisibilitiReportMissingTimePerProcess(true);
                break;
            case C_REPORT_FOR_STATUS_CHANGE_PROCESS:
                // reporte por cambio de estado de los procesos
                // reportStatusChangeProcess();
                // jPrincipal.dialogVisibilitiStatusChangeProcess(true);
                break;
            case C_REPORT_BY_STATES:
                // reporte por orden en el estado en listo
                // reportByStates();
                // jPrincipal.dialogVisibilitiReadyState(true);
                break;
            case C_REPORT_FOR_STATUS_CHANGE:
                // reporte por cambios de estado de cada proceso
                reportForStatusChange();
                // jPrincipal.dialogVisibilitiStatusChange(true);
                break;

            default:
                break;
        }
    }

    public void addProcessTable() {
        jPrincipal.setInformationProcessTable();
    }

    public void executeProcess() {
        // set time
        int time = jPrincipal.getTimeCPU();
        // set lista de procesos
        executeListProcess(time, jPrincipal.getInformation());
    }

    public void executeListProcess(int time, ArrayList<Object[]> listProcess) {
        int timeCPU = time;
        // listProcess.forEach(x -> executeProcess.addProcessToQueue(new Process(
        // x[0],x[1] ,x[2])));
        for (int i = 0; i < listProcess.size(); i++) {
            Object[] vector = (Object[]) listProcess.get(i);
            System.out.println("---" + listProcess.get(i)[0]);
            executeProcess.addProcessToQueue(new Process("" + listProcess.get(i)[0], Integer.parseInt("" + vector[1]),
                    Boolean.parseBoolean("" + vector[2])));

        }
        executeProcess.init(timeCPU);
    }

    public void reportview() {
        executeProcess.reports(printWriter);
        printWriter.close();
    }

    /*
     * public void reportMissingTimeProcess() {
     * executeProcess.reportMissingTimeProcess();
     * }
     * 
     * public void reportStatusChangeProcess() {
     * executeProcess.reportStatusChangeProcess();
     * }
     * 
     * public void reportByCpuExecuteOrder() {
     * executeProcess.reportByCpuExecuteOrder();
     * }
     * 
     * public void reportByStates() {
     * executeProcess.reportByStates();
     * }
     * 
     * 
     * public ArrayList<String[]> reportByLockedStates() {
     * return executeProcess.reportByLockedStates();
     * }
     * 
     * public ArrayList<String[]> reportByExitState() {
     * return executeProcess.reportByExitState();
     * }
     */
    public void reportForStatusChange() {
        executeProcess.reportForStatusChange();
    }
}
