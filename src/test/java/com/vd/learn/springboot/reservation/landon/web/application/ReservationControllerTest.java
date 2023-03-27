package com.vd.learn.springboot.reservation.landon.web.application;

import com.vd.learn.springboot.reservation.landon.business.domain.RoomReservation;
import com.vd.learn.springboot.reservation.landon.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getReservations() throws Exception{
        Date date = DATE_FORMAT.parse("2023-03-27");
        List<RoomReservation> mockReservationList = new ArrayList<>();
        RoomReservation mockRoomReservation = new RoomReservation();
        mockRoomReservation.setLastName("Test");
        mockRoomReservation.setFirstName("JUnit");
        mockRoomReservation.setDate(date);
        mockRoomReservation.setGuestId(1);
        mockRoomReservation.setRoomNumber("J1");
        mockRoomReservation.setRoomId(100);
        mockRoomReservation.setRoomName("JUnit Room");
        mockReservationList.add(mockRoomReservation);

        String mockUrl = "/reservations?date=2023-03-27”";
        given(reservationService.getRoomReservationsForDate("2023-03-27")).willReturn(mockReservationList);

        this.mockMvc.perform(get(mockUrl))
        .andExpect(status().isOk());
//        .andExpect(content().string("Test, JUnit"));
//        content().string(containsString("Test, JUnit"));
//
        List<RoomReservation> reservations = reservationService.getRoomReservationsForDate("2023-03-27");
        System.out.println("Total: " + reservations.size());
        reservations.forEach(reservation -> System.out.println(reservation.getLastName() + ", " + reservation.getFirstName() + " " + reservation.getDate()));

//        this.mockMvc.perform(get(mockUrl))
//            .andExpect(status().isOk())
//            .andExpect(content().string(containsString("Test, JUnit")));


    }
}
