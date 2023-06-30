package me.tadebois.entain.nedapi

object ApiResponseTestData {
    const val GET_NEXT_TWO_RACES_RESPONSE = """
{
    "status": 200,
    "data": {
        "next_to_go_ids": [
            "22407939-7b9d-495e-863f-bd56b9179522",
            "d8ffbaed-7d82-4e9e-806f-0b3825a1c1f4"
        ],
        "race_summaries": {
            "22407939-7b9d-495e-863f-bd56b9179522": {
                "race_id": "22407939-7b9d-495e-863f-bd56b9179522",
                "race_name": "Zack Monelli At Stud",
                "race_number": 8,
                "meeting_id": "8e532dca-faaa-41b6-ab2d-4d6a4cd83c0a",
                "meeting_name": "Cannington",
                "category_id": "9daef0d7-bf3c-4f50-921d-8e818c60fe61",
                "advertised_start": {
                    "seconds": 1688131020
                },
                "race_form": {
                    "distance": 520,
                    "distance_type": {
                        "id": "570775ae-09ec-42d5-989d-7c8f06366aa7",
                        "name": "Metres",
                        "short_name": "m"
                    },
                    "distance_type_id": "570775ae-09ec-42d5-989d-7c8f06366aa7",
                    "track_condition": {
                        "id": "10a14653-a33d-11e7-810d-0a1a4ae29bd2",
                        "name": "Good",
                        "short_name": "good"
                    },
                    "track_condition_id": "10a14653-a33d-11e7-810d-0a1a4ae29bd2",
                    "weather": {
                        "id": "08e5f78c-1a36-11eb-9269-cef03e67f1a3",
                        "name": "FINE",
                        "short_name": "fine",
                        "icon_uri": "FINE"
                    },
                    "weather_id": "08e5f78c-1a36-11eb-9269-cef03e67f1a3",
                    "race_comment": "IT'S A DIME (2) is worth forgiving for her last effort when fifth (30.77) at this track over 520m. Form here at this distance is sound. Boasts a strong record from this draw with three wins and four minor placings from seven starts. Rates on top in this line up. MY TIME (5) copped a check in the run and boxed on to place when a one length second (30.28) in a Grade 4/5 at this track. Rates a key player. SHIAN PEDRO (1) has been hard to follow lately, running sixth (35.83) last time but prior to that ran very well when placed at this track. Can feature with the right run.",
                    "additional_data": "{\"revealed_race_info\":{\"track_name\":\"Cannington\",\"state\":\"WA\",\"country\":\"AUS\",\"number\":8,\"race_name\":\"Zack Monelli At Stud\",\"time\":\"2023-06-30T13:17:00Z\"}}",
                    "generated": 1,
                    "silk_base_url": "drr38safykj6s.cloudfront.net",
                    "race_comment_alternative": "IT'S A DIME (2) is worth forgiving for her last effort when fifth (30.77) at this track over 520m. Form here at this distance is sound. Boasts a strong record from this draw with three wins and four minor placings from seven starts. Rates on top in this line up. MY TIME (5) copped a check in the run and boxed on to place when a one length second (30.28) in a Grade 4/5 at this track. Rates a key player. SHIAN PEDRO (1) has been hard to follow lately, running sixth (35.83) last time but prior to that ran very well when placed at this track. Can feature with the right run."
                },
                "venue_id": "9b3705d7-d2f4-43ce-97ba-5dde4d3bce77",
                "venue_name": "Cannington",
                "venue_state": "WA",
                "venue_country": "AUS"
            },
            "d8ffbaed-7d82-4e9e-806f-0b3825a1c1f4": {
                "race_id": "d8ffbaed-7d82-4e9e-806f-0b3825a1c1f4",
                "race_name": "Newcastle Greyhounds On Sky Sports Racing Stakes",
                "race_number": 2,
                "meeting_id": "7017a8b2-9d78-4c48-9512-83fdd8f80672",
                "meeting_name": "Newcastle Bags.",
                "category_id": "9daef0d7-bf3c-4f50-921d-8e818c60fe61",
                "advertised_start": {
                    "seconds": 1688131140
                },
                "race_form": {
                    "distance": 480,
                    "distance_type": {
                        "id": "570775ae-09ec-42d5-989d-7c8f06366aa7",
                        "name": "Metres",
                        "short_name": "m"
                    },
                    "distance_type_id": "570775ae-09ec-42d5-989d-7c8f06366aa7",
                    "track_condition": {
                        "id": "10a14653-a33d-11e7-810d-0a1a4ae29bd2",
                        "name": "Good",
                        "short_name": "good"
                    },
                    "track_condition_id": "10a14653-a33d-11e7-810d-0a1a4ae29bd2",
                    "weather": {
                        "id": "08e5f78c-1a36-11eb-9269-cef03e67f1a3",
                        "name": "FINE",
                        "short_name": "fine",
                        "icon_uri": "FINE"
                    },
                    "weather_id": "08e5f78c-1a36-11eb-9269-cef03e67f1a3",
                    "race_comment": "SWIFT UNHALLOWED (5) is a last start HCP winner, jumping from this trap and scoring by a nose over 480m at this track. Boasts a strong record off this same draw, including two and seven places from 12 starts. Expected to go close again. MALBAY CALLIE (6) jumps from trap 6 for the first time after placing latest at this track (29.40) in an A2. Has clocked a fast 29 best time here at this trip. Hard to beat again. SLIPPY KEVIN (3) broke through for his maiden success two back but could manage only midfield last time when finished fourth and beaten 3.5 lengths at this track over 480m (29.67). Expected to bounce back to best. GARTCLOSS GEORDI (4) can return to form after missing the top-three at this circuit last time out.",
                    "additional_data": "{\"revealed_race_info\":{\"track_name\":\"\",\"state\":\"\",\"country\":\"\",\"number\":0,\"race_name\":\"\",\"time\":\"1970-01-01T00:00:00Z\"}}",
                    "generated": 1,
                    "silk_base_url": "drr38safykj6s.cloudfront.net",
                    "race_comment_alternative": "SWIFT UNHALLOWED (5) is a last start HCP winner, jumping from this trap and scoring by a nose over 480m at this track. Boasts a strong record off this same draw, including two and seven places from 12 starts. Expected to go close again. MALBAY CALLIE (6) jumps from trap 6 for the first time after placing latest at this track (29.40) in an A2. Has clocked a fast 29 best time here at this trip. Hard to beat again. SLIPPY KEVIN (3) broke through for his maiden success two back but could manage only midfield last time when finished fourth and beaten 3.5 lengths at this track over 480m (29.67). Expected to bounce back to best. GARTCLOSS GEORDI (4) can return to form after missing the top-three at this circuit last time out."
                },
                "venue_id": "24a08e96-c328-4264-9f48-cbc2bc09e5f7",
                "venue_name": "Newcastle Bags.",
                "venue_state": "UK",
                "venue_country": "UK"
            }
        }
    },
    "message": "Next 2 races from each category"
}
        """
}
