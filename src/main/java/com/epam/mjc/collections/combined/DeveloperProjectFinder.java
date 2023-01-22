package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> developersProject = new ArrayList<>();
        for (Map.Entry<String, Set<String>> project : projects.entrySet()) {
            if (project.getValue().contains(developer)) {
                developersProject.add(project.getKey());
            }
        }
        developersProject.sort(new SortProjectsBtLengthAndThenAlphabetically());
        Collections.reverse(developersProject);
        return developersProject;
    }

    private static class SortProjectsBtLengthAndThenAlphabetically implements Comparator<String> {
        @Override
        public int compare(String project1, String project2) {
            if (project1.length() == project2.length()) {
                return project1.compareTo(project2);
            }
            return project1.length() - project2.length();
        }
    }
}
