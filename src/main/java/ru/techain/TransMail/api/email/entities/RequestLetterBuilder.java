package ru.techain.TransMail.api.email.entities;

import java.util.Map;

public class RequestLetterBuilder extends LetterBuilder {
    private StringBuilder builder = new StringBuilder();

    public RequestLetterBuilder addPrefix(String prefix) {
        builder.append(prefix);
        builder.append("</br>");
        return this;
    }

    public RequestLetterBuilder addPrizes(Map<String, Integer> prizes) {
        for(Map.Entry<String, Integer> prize : prizes.entrySet()) {
            builder.append(constructRequestLine(prize));
        }
        return this;
    }

    public RequestLetterBuilder addPrizes(String prizes) {
        builder.append(prizes);
        return this;
    }

    private String constructRequestLine(Map.Entry<String, Integer> prize) {
        return String.format("%d шт - %s </br>", prize.getValue(), prize.getKey());
    }

    public RequestLetterBuilder addSuffix(String prefix) {
        builder.append(prefix);
        return this;
    }

    @Override
    public Letter build() {
        super.setContent(builder.toString());
        return super.build();
    }
}
