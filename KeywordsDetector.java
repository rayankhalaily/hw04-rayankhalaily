public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    public static void detectAndPrint(String[] sentences, String[] keywords) {

        // Loop over all sentences
        for (int i = 0; i < sentences.length; i++) {

            // Convert the full sentence to lowercase once
            String sentenceLower = sentences[i].toLowerCase();

            // Check each keyword inside the sentence
            boolean found = false;

            for (int j = 0; j < keywords.length; j++) {

                // Lowercase keyword for case-insensitive match
                String keywordLower = keywords[j].toLowerCase();

                // Check if the sentence contains the keyword
                if (sentenceLower.contains(keywordLower)) {
                    found = true;
                    break; // No need to check more
                }
            }

            // If any keyword was found → print the 
            if (found) {
                System.out.println(sentences[i]);
            }
        }
    }
}