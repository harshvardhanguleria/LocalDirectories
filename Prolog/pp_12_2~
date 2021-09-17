symptom(cersie, low_grade_fever).
symptom(cersie, headache).
symptom(cersie, runny_nose).
symptom(cersie, sore_throat).

symptom(danaerys, watery_stools).
symptom(danaerys, fever).
symptom(danaerys, abdominal_pain).
symptom(danaerys, abdominal_cramps).
symptom(danaerys, dizziness_from_dehydration).

symptom(ramsay, urinating_often).
symptom(ramsay, extreme_fatigue).
symptom(ramsay, blurry_vision).
symptom(ramsay, weight_loss).
symptom(ramsay, numb_hands_and_feet).

diagnosis(P, diarrhea) :- symptom(P, watery_stools),
				symptom(P, abdominal_pain),
				symptom(P, dizziness_from_dehydration),
				symptom(P, abdominal_cramps),
				symptom(P, fever).

diagnosis(P, diabetes) :- symptom(P, urinating_often),
                                symptom(P, extreme_fatigue),
				symptom(P, blurry_vision),
				symptom(P, weight_loss),
				symptom(P, numb_hands_and_feet).

diagnosis(P, common_cold) :- symptom(P, low_grade_fever),
                                   symptom(P, headache),
				   symptom(P, runny_nose),
				   symptom(P, sore_throat).
