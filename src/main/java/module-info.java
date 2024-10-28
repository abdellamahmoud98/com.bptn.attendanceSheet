module com.bptn.attendance.system.attendance_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.bptn.attendance.system.attendance_system to javafx.fxml;
    exports com.bptn.attendance.system.attendance_system;
    exports com.bptn.attendance.system.attendance_system.controllers;
    opens com.bptn.attendance.system.attendance_system.controllers to javafx.fxml;
    exports com.bptn.attendance.system.attendance_system.models;
    opens com.bptn.attendance.system.attendance_system.models to javafx.fxml;
}