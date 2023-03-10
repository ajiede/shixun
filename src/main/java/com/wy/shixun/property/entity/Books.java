package com.wy.shixun.property.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wy.shixun.account.entity.User;
import com.wy.shixun.common.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="economy_books")
public class Books extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private int userId;
    private String name;
    private String booksType;
    private boolean defaultBooks;

    @Transient
    private List<User> members;//成员
    @Transient
    private double inflow;//流水
    @Transient
    private double outflow;//流出
    @Transient
    private double balance;//余额

    public Books(int id, LocalDateTime createDate, LocalDateTime updateTime) {
        super(id, createDate, updateTime);
    }

    public Books() {
        super();
    }


    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum BooksType {
        FAMILY_BOOKS("家庭账簿", "fd-insurance-icon ll-icon"),
        PERSONAL_BOOKS("个人账簿", "fd-bond-icon ll-icon"),
        ;

        public String name;
        public String icon;

        private BooksType(String name, String icon) {
            this.name = name;
            this.icon = icon;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public String getBooksType() {
        return booksType;
    }

    public void setBooksType(String booksType) {
        this.booksType = booksType;
    }

    public boolean isDefaultBooks() {
        return defaultBooks;
    }

    public boolean getDefaultBooks() {
        return defaultBooks;
    }

    public void setDefaultBooks(boolean defaultBooks) {
        this.defaultBooks = defaultBooks;
    }

    public double getInflow() {
        return inflow;
    }

    public void setInflow(double inflow) {
        this.inflow = inflow;
    }

    public double getOutflow() {
        return outflow;
    }

    public void setOutflow(double outflow) {
        this.outflow = outflow;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
