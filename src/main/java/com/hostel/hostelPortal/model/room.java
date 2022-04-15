package com.hostel.hostelPortal.model;

import javax.persistence.*;
@Entity

@Table(name="Room")
public class room
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int  roomId;
    public int occupied;
    public int  studentId;
    public  String joiningDate;

    public room(int roomId, int occupied, int studentId, String joiningDate) {
        this.roomId = roomId;
        this.occupied = occupied;
        this.studentId = studentId;
        this.joiningDate = joiningDate;
    }

    public room()
    {

    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
}
