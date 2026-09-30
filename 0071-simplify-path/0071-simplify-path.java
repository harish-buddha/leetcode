class Solution {
    public String simplifyPath(String path) {
         Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            // Ignore empty components and current directory.
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            // Move to parent directory.
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Normal directory/file name.
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append('/').append(stack.removeLast());
        }

        return result.toString();
    }
}