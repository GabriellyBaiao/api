package br.com.vivo.api.validator;

import br.com.vivo.api.model.Candidate;
import br.com.vivo.api.model.Skills;
import br.com.vivo.api.model.ProgrammingLanguages;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class CandidateValidator implements Validator {

    //    private static final String[] SKILLS_LEVEL = {"Backend", "Frontend"};
//    private static final String[] PROGRAMING_LANGUAGE = {"Java", "C#", "Golang", "Javascript", "Vue", "PHP"};
    @Override
    public boolean supports(Class<?> clazz) {
        return Candidate.class.equals(clazz);

    }

    @Override
    public void validate(Object obj, Errors e) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(e, "skillLevel", "NotEmpty");

        Candidate candidate = (Candidate) obj;

        if (!candidate.getSkills().get(0).equals(ProgrammingLanguages.PHP)) {
            e.rejectValue("skills", "não tem todas skills");
        }
        for (Skills skills: candidate.getSkills()) {
            if(skills.getName() == null){
                e.rejectValue("name", "Não tem todas as skills.");
            }
            if(skills.getScore() == null){
                e.rejectValue("name", "Não tem todas as scores.");
            }
        }
    }
//        String skillsLevel = candidate.getSkillsLevel();
//        if (skillsLevel != null && skillsLevel.length() > 0) {
//            boolean isValid = false;
//            for (String level : SKILLS_LEVEL) {
//                if ( level.equals(skillsLevel)) {
//                    isValid = true;
//                    break;
//                }
//            }
//            if (!isValid) {
//                e.rejectValue("skillsLevel", "InvalidSkillsLevel");
//            }
//        }
//        String language = candidate.getLanguage();
//        if (language != null && language.length() > 0) {
//            boolean isValid = false;
//            for (String 1 :PROGRAMING_LANGUAGE){
//                if (1. equals(language)){
//                    isValid = true;
//                    break;
//                }
//            }
//            if (!isValid) {
//                e.rejectValue("language", "InvalidProgramingLanguage");
//            }
//        }
//    }
//}
//

//        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
//        SkillDTO s = (SkillDTO) obj;
//        if (s.getScore() < 0 || s.getScore() > 10) {
//            e.rejectValue("score", "valor invalido");
//        } else if (s.getScore() == null) {
//            e.rejectValue("score", "valor invalido");
//        }
}
