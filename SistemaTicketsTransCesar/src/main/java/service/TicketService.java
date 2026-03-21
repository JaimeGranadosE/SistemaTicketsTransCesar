/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import java.util.ArrayList;
import java.util.List;
import model.Ticket;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();

    public void registrarTicket(Ticket t) {
        tickets.add(t);
        System.out.println("Ticket vendido: " + t.getPasajero().getNombre());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}