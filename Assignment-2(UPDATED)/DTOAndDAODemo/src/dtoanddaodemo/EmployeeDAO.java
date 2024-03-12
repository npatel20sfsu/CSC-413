/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtoanddaodemo;

import java.sql.SQLException;

public interface EmployeeDAO extends DAOInterface<Employee> {

    @Override
    Employee get(int anID) throws SQLException;

    @Override
    int insert(Employee emp) throws SQLException;

    @Override
    int update(Employee emp) throws SQLException;

    @Override
    int delete(Employee emp) throws SQLException;

    @Override
    int save(Employee emp) throws SQLException;

    // Additional methods specific to EmployeeDAO can be added here if needed
}
