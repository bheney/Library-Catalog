package main.java.com.LibraryCatalog.catalog;

import main.java.com.LibraryCatalog.dao.Database;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Search {
    private String querry;
    private Search (String querry){
        this.querry=querry;
    }

    public class Builder {
        private String querry;
        private Set<String> resultFields;
        private String searchField;
        private String media;
        private String exactMatch;
        private Set<String> keywords;

        public Builder Builder () {
            resultFields = new HashSet<String>();
            keywords = new HashSet<String>();
            return this;
        }

        public Builder addResultField(String field) {
            resultFields.add(field);
            return this;
        }

        public Builder addMedia(Media media){
            this.media = media.getType();
            return this;
        }

        public Builder addKeyWordString(String keywords) {
            keywords = Database.sanitize(keywords);
            exactMatch = keywords;
            String[] tokens = keywords.split(" ");
            Collections.addAll(this.keywords, tokens);
            return this;
        }

        public Builder addSearchField(String field) {
            searchField = field;
            return this;
        }

        public Search build() {
            // SELECT
            querry = "SELECT ";

            // FROM
            querry += buildFROM();

            // WHERE
            querry += buildWHERE();

            return new Search(querry);

        }

        private String buildFROM () {
            if (resultFields.isEmpty()) {
                return "* FROM ";
            }
            StringBuilder statement = new StringBuilder();
            String[] fieldList = resultFields.toArray(new String[0]);
            for (int i=0; i<fieldList.length; i++) {
                statement.append(fieldList[i]);
                if (i == fieldList.length -1) statement.append(" ");
                else statement.append(", ");
            }
            statement.append("FROM ").append(media);
            return statement.toString();
        }

        private String buildWHERE () {
            StringBuilder statement = new StringBuilder("WHERE ");
            String[] tokens = keywords.toArray(new String[0]);
            for (int i=0; i< tokens.length; i++){
                statement.append(searchField);
                statement.append(" LIKE %");
                statement.append(tokens[i]);
                statement.append("%");
                if (i== tokens.length-1) statement.append(";");
                else statement.append(" OR ");
            }
            return statement.toString();
        }
    }

}


