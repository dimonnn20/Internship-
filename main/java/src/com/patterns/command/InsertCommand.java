package com.patterns.command;

public class InsertCommand implements Command {
    private Database db;

    public InsertCommand(Database db) {
        this.db = db;
    }

    @Override
    public void execute() {
        db.insert();
    }
}
