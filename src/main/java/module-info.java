module com.example.rpgfxmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.media;

    opens com.example.rpgfxmaven to javafx.fxml;
    exports com.example.rpgfxmaven;
    exports com.example.rpgfxmaven.characters;
    opens com.example.rpgfxmaven.characters to javafx.fxml;
    exports com.example.rpgfxmaven.objects;
    opens com.example.rpgfxmaven.objects to javafx.fxml;
    exports com.example.rpgfxmaven.logic;
    opens com.example.rpgfxmaven.logic to javafx.fxml;
}