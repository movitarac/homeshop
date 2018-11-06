package com.racic.homeshop;

public interface Writer {
    /**
     * Start writing process
     */

    public void start();



    /**
     * write on line
     * @param line
     */
    public void writeLine(String line);

    /**
     * Stop writing process
     */
    public void stop();
}
