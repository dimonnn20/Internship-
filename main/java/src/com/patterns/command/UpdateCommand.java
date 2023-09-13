package com.patterns.command;

public class UpdateCommand implements Command{
    private Database db;

    public UpdateCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.update();
    }
}
