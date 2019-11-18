package com.momenton.codechallenge.domain;

/**
 * @author Bahar Javidan
 * @since 2019-11-17
 */
public class Subordinate extends Employee {

    public Subordinate(int employeeId, String name, int managerId) {
        super(employeeId, name, managerId);
    }

    @Override
    public void print(int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("\t");
        }
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
