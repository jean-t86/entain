# Entain Technical Task

## Environment setup

If you only plan on running the app in it's debug build type configuration, skip this section.

If you want to run the application in it's release configuration, you will need to obtain the
keystore credentials and secrets. Those are temporarily stored in a 1Password vault in my personal
1Password account.

In an industry setting, we could use a different Secrets Manager software.

For now, I will pass on `config.properties` with the right credentials via email attachment. The
future goal is to write a script that automatically fetches the credentials and
generates `config.properties` file. It will be called `setup_dev_environment.sh`.

Copy the attached file to the project's root folder, making sure to overwrite the existing mock
file.

You can now run the application in the Release build type.

## Technical Task Description

Thank you for your application for the Mobile engineer position at Entain. As part of our interview
process, we have prepared the following technical task to get a better understanding of your skills,
thought process and methodology.

There is no fixed time limit on this task, what matters is that you demonstrate your knowledge and
skills to the best of your ability. Please upload your solution to a private repository and send us
a link, include any testing instructions.

Task
Create an Android app that displays ‘Next to Go’ races using our API.
A user should always see 5 races, and they should be sorted by time ascending. Race should disappear
from the list after 1 min past the start time, if you are looking for inspiration look
at [https://www.neds.com.au/next-to-go](https://www.neds.com.au/next-to-go)

Requirements
As a user, I should be able to see a time ordered list of races ordered by advertised start
ascending
As a user, I should not see races that are one minute past the advertised start
As a user, I should be able to filter my list of races by the following categories: Horse, Harness &
Greyhound racing
As a user, I can deselect all filters to show the next 5 from of all racing categories
As a user I should see the meeting name, race number and advertised start as a countdown for each
race.
As a user, I should always see 5 races and data should automatically refresh

Technical Requirements
Use Jetpack compose
Use Kotlin
Has some level of testing. Full coverage is not necessary, but there should be at least some testing
for key files.
Documentation
Use scalable layouts so your app can respond to font scale changes
Use material design elements over custom elements
(Optional) use data binding
(Optional) add accessibility labels such that you can navigate via voiceover

```
Categories are defined by IDs and are the following:
- Greyhound racing: category_id: 9daef0d7-bf3c-4f50-921d-8e818c60fe61
- Harness racing: category_id: 161d9be2-e909-4326-8c2c-35ed71fb460b
- Horse racing: category_id: 4a2788f8-e825-4d36-9894-efd4baf1cfae

GET https://api.neds.com.au/rest/v1/racing/?method=nextraces&count=10
Content-type: application/json
```
