package ContextStrategy;

import Users.User;
import java.util.ArrayList;
import java.util.List;

public class UserContext implements Strategy {

    private List<Object> users = new ArrayList<>();

    @Override
    public Object get(int id) {
        for (Object o : users) {
            User user = (User) o;
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            boolean exist = false;
            User user = (User) o;
            List<Object> users = getAll();
            for (int i=0; i<users.size()-1; i++) {
                Object e = users.get(i);
                User eu = (User) e;
                if(eu.getEmail().equals(user.getEmail())) return false;
            }
            if(!exist)
                users.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            User user = (User) o;
            users.remove(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Object> getAll() {
        return users;
    }

    @Override
    public boolean update(Object o) {
        try {
            User user = (User) o;
            users.remove(user);
            users.add(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
