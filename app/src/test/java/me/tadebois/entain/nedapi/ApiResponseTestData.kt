package me.tadebois.entain.nedapi

object ApiResponseTestData {
    const val GET_NEXT_TWO_RACES_RESPONSE = """
            {
                "status": 200,
                "data": {
                    "next_to_go_ids": ["1", "2"],
                    "race_summaries": {
                        "1": {
                            "race_id": "1",
                            "race_name": "Race 1",
                            "race_number": 1,
                            "meeting_id": "meeting1",
                            "meeting_name": "Meeting 1",
                            "category_id": "category1",
                            "advertised_start": {
                                "seconds": 1624567890
                            },
                            "race_form": {
                                "distance": 1000,
                                "distance_type": {
                                    "id": "distance1",
                                    "name": "Distance 1",
                                    "short_name": "D1"
                                },
                                "track_condition": {
                                    "id": "condition1",
                                    "name": "Condition 1",
                                    "short_name": "C1"
                                },
                                "weather": {
                                    "id": "weather1",
                                    "name": "Weather 1",
                                    "short_name": "W1",
                                    "icon_uri": "weather1.png"
                                },
                                "race_comment": "Comment 1",
                                "additional_data": "Additional data 1",
                                "generated": 1,
                                "silk_base_url": "http://silk.example.com/",
                                "race_comment_alternative": "Alternative comment 1"
                            },
                            "venue_id": "venue1",
                            "venue_name": "Venue 1",
                            "venue_state": "State 1",
                            "venue_country": "Country 1"
                        },
                        "2": {
                            "race_id": "2",
                            "race_name": "Race 2",
                            "race_number": 2,
                            "meeting_id": "meeting2",
                            "meeting_name": "Meeting 2",
                            "category_id": "category2",
                            "advertised_start": {
                                "seconds": 1624567900
                            },
                            "race_form": {
                                "distance": 1200,
                                "distance_type": {
                                    "id": "distance2",
                                    "name": "Distance 2",
                                    "short_name": "D2"
                                },
                                "track_condition": {
                                    "id": "condition2",
                                    "name": "Condition 2",
                                    "short_name": "C2"
                                },
                                "weather": {
                                    "id": "weather2",
                                    "name": "Weather 2",
                                    "short_name": "W2",
                                    "icon_uri": "weather2.png"
                                },
                                "race_comment": "Comment 2",
                                "additional_data": "Additional data 2",
                                "generated": 2,
                                "silk_base_url": "http://silk.example.com/",
                                "race_comment_alternative": "Alternative comment 2"
                            },
                            "venue_id": "venue2",
                            "venue_name": "Venue 2",
                            "venue_state": "State 2",
                            "venue_country": "Country 2"
                        }
                    }
                },
                "message": "Success"
            }
        """
}
