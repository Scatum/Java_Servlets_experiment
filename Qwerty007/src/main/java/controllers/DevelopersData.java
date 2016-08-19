package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import domains.Task;
import domains.User;
import utils.TaskProgress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ScatUm on 18.08.2016.
 */
@WebServlet("/developers-data")
public class DevelopersData extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JsonArray data = null;
        try {
            List<User> developers = Factory.getInstance().getUserDao().getFiltrUsers();
            JsonObject obj = new JsonObject();
            JsonArray array = new JsonArray();
            for (User user : developers) {
                data = new JsonArray();

                data.add(new JsonPrimitive(user.getU_name()));
                data.add(new JsonPrimitive(user.getU_about()));
                int toDo = 0;
                int onHold = 0;
                int done = 0;
                int inProgress = 0;
                int inReview = 0;
                for (Task task : user.getTasks()) {
                    switch (task.getType()) {
                        case TaskProgress.TO_DO:
                            toDo++;
                            break;
                        case TaskProgress.ON_HOLD:
                            onHold++;
                            break;
                        case TaskProgress.IN_PROGRES:
                            inProgress++;
                            break;
                        case TaskProgress.IN_REVIEW:
                            inReview++;
                            break;
                        case TaskProgress.DONE:
                            done++;
                            break;
                    }
                }
                data.add(new JsonPrimitive(toDo));
                data.add(new JsonPrimitive(onHold));
                data.add(new JsonPrimitive(inProgress));
                data.add(new JsonPrimitive(inReview));
                data.add(new JsonPrimitive(done));
                data.add(new JsonPrimitive(user.getTasks().size()));
                array.add(data);
            }


            obj.add("data", array);
            String res = new Gson().toJson(obj);
            response.getWriter().write(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
