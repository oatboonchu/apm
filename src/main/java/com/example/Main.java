package com.example;

import co.elastic.apm.attach.ElasticApmAttacher;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.crud;

public class Main {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        Javalin app = Javalin.create(
                config -> {
                    config.enableCorsForAllOrigins();
                }
        )
                .start(8080);

        app.routes(() -> crud("/students/:student-id", new StudentController()));
    }
}