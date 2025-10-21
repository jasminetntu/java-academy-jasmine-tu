package com.hoteloperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    // *** checkIn()
    @Test
    void checkIn_RoomIsAvailable_SuccessfulCheckIn() {
        //arrange
        Room room = new Room(1, 139); //suite

        //act
        room.checkIn();

        //assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkIn_RoomIsOccupied_FailCheckIn() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();

        //act
        room.checkIn();

        //assert
        //todo: what would you do if you had a print?
    }

    @Test
    void checkIn_RoomIsUnoccupiedButDirty_FailCheckIn() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();
        room.checkOut();

        //act
        room.checkIn();

        //assert
        //todo: what would you do if you had a print?
    }

    // *** checkOut()
    @Test
    void checkOut_RoomIsOccupied_SuccessfulCheckOut() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();

        //act
        room.checkOut();

        //assert
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkOut_RoomIsUnoccupied_FailCheckOut() {
        //arrange
        Room room = new Room(1, 139); //suite

        //act
        room.checkOut();

        //assert
        //todo: what would you do if you had a print?
    }

    // *** cleanRoom()
    @Test
    void cleanRoom_RoomIsDirty_SuccessfulCleanRoom() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();
        room.checkOut();

        //act
        room.cleanRoom();

        //assert
        assertFalse(room.isDirty());
    }

    @Test
    void cleanRoom_RoomIsOccupied_FailCleanRoom() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();

        //act
        room.cleanRoom();

        //assert
        //todo: what would you do if you had a print?
    }

    @Test
    void cleanRoom_RoomIsNotDirty_FailCleanRoom() {
        //arrange
        Room room = new Room(1, 139); //suite
        room.checkIn();
        room.checkOut();
        room.cleanRoom();

        //act
        room.cleanRoom();

        //assert
        //todo: what would you do if you had a print?
    }
}