---
title: CTC Traders Phase 5 service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with Common Transit Convention Traders API.
---

# CTC Traders API phase 5 service guide

## Useful CTC Page Links
[CTC Traders API roadmap](https://developer.service.hmrc.gov.uk/roadmaps/common-transit-convention-traders-roadmap/#phase-5)

[CTC Traders API specification](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/2.0)

[CTC Traders API phase 5 testing guide](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/)

## Introduction
This guide explains how to use the Common Transit Convention (CTC) Traders API with your software.

The CTC Traders API allows traders to send and receive arrival and departure movements to and from the New Computerised Transit System (NCTS) for Great Britain and Northern Ireland.

**Note:** Current development focuses on small messages (0.5MB and below only). Development for messages larger than 0.5MB will begin at a later date.

## Essential Reading
Before starting, you must read and understand:

- [New Computerised Transit System: technical interface specifications (TIS)](https://www.gov.uk/government/publications/new-computerised-transit-system-technical-specifications) 

&nbsp;&nbsp;&nbsp;&nbsp;The Technical Interface Specification (TIS) for Direct Trader Input (DTI) to NCTS.

&nbsp;&nbsp;&nbsp;&nbsp;A full list of key information including messages, message content and sequence diagrams, plus instructions on how to use test message transfer and content.

- [message structure hierarchy for IE007 messages](figures/Message_Structure_Hierarchy_IE007.pdf)

- [message structure hierarchy for IE015 messages](figures/Message_Structure_Hierarchy_IE015.pdf)

- [message structure data grouping](figures/Data_Structure_Group_IE15.pdf) 

- [P4 to P5 data mapping](figures/NCTS_P4_to_P5_data_mapping_R1_v1_(V5.7_RFC36_aligned).xlsx)


## Getting Started

These steps must be followed before you can use your software in the live environment and access our live API:

1. **Subscribe** to the Developer Hub by [registering for a developer account](https://developer.service.hmrc.gov.uk/developer/registration).
2. **Create** an application by following the instructions on [Using the Developer Hub](https://developer.qa.tax.service.gov.uk/api-documentation/docs/using-the-hub).
3. **Subscribe** to the CTC Traders API and to the Test User API using your test application.
4. **Opt to receive** Push notifications from the CTC Traders API if required using the Subscription Configuration page for your application.
5. **Read** about the [Government Gateway Authorisation](https://developer.qa.tax.service.gov.uk/api-documentation/docs/authorisation). Before you can access the CTC Traders API, your software needs to authenticate using OAuth 2.0.
6. **Read** guidance on the [OAuth 2.0](https://developer.service.hmrc.gov.uk/api-documentation/docs/authorisation) standards required for all of HMRC’s APIs.
7. **Create** [test users](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0) before you can test your application.
8. **Download** reference data to get Customs Offices List (COL) data to use for testing. Visit the [EU’s reference data download page](https://ec.europa.eu/taxation_customs/dds2/rd/rd_download_home.jsp?Lang=en) to download reference data.
9. **Test** your application in the sandbox environment by following the steps in our [Guide to Testing](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/).
10. **Complete** the [Application for Productions Checklist](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/figures/CTC_Traders_API_Application_for_Productions_Credentials.docx) form.
11. **Apply** for production credentials through your [developer account](https://developer.service.hmrc.gov.uk/developer/login) before you go live.
12. **Get your customers ready** by asking them to apply for an [EORI number](https://www.gov.uk/eori) and a [Government Gateway account](https://www.gov.uk/log-in-register-hmrc-online-services).

## Get your customers ready

Your customers need to [sign up to the CTC Traders API](https://www.tax.service.gov.uk/customs-enrolment-services/ctc/subscribe) and provide you with the following details:

* GB Economic Operators Registration and Identification (EORI) number
* VAT details (optional) 
* Standard Industrial Classification (SIC) code
* company or organisation details: 
  * unique tax reference (UTR) number 
  * registered company name (this must be an exact match)
  * registered company address 
  * date of company establishment 

They will also need to provide:
 
* email address 
* contact details


## Message Flow Diagrams

The following diagrams show the expected order of messages that can be sent and received.

### Departures

The following diagram shows the messages that the office of departure receives. 

<img src="figures/Departures_Diagram.svg" alt="Departures workflow flow. Flow is described in this section." />

<a href="figures/Departures_Diagram.svg" target="_blank">Open the Departures diagram in a new tab.</a>

1. An IE015 message containing declaration data is sent by the user to NCTS.
2. NCTS responds with one of the following messages: 
   - An IE016 message if the declaration is rejected. The transit movement ends.
   - An IE028 message if an MRN is allocated. (Go to step 3.)
   - An IE928 message for a positive acknowledgment followed by an IE016 or an IE028 (see previous options in this step).
3. If the user sends an IE014 declaration cancellation request, NCTS sends an IE009 cancellation decision. This also happens following a cancellation request by the office of departure. A cancellation decision has one of the following outcomes: 
   - The cancellation request is accepted and the transit movement ends.
   - The cancellation request is rejected and NCTS sends an IE029 release for transit. (Go to step 5.)
4. If the user does not send an IE014 declaration cancellation request following the allocation of an MRN (see step 2), one of the following actions takes place:
   - NCTS sends an IE060 control of decision notification, then sends either an IE029 release for transit (Go to step 5.) or an IE051 no release for transit message. 
   - NCTS sends an IE051 no release for transit message. At this point, the transit movement ends.
   - NCTS sends an an IE055 guarantee not valid message. If there is an intervention, NCTS then sends an IE029 release for transit. If there is no intervention, NCTS then sends an IE051 no release for transit message. 
   - NCTS sends an IE029 release for transit message (Go to step 5.)
5. When NCTS issues an IE029 release for transit (following an IE028, an IE060, or an IE009), one of the following actions takes place:
   - The user chooses to send an IE014 declaration cancellation request.
   - A cancellation is requested by the office of departure, which results in NCTS sending an IE009 cancellation decision message. (Go to step 3.)
   - Upon completion of the arrival, an IE045 write-off notification movement is issued by NCTS. 

### Arrivals

The following diagram shows the messages that the office of destination receives.

<img src="figures/Arrivals_Diagram.svg" alt="Arrivals workflow flow. Flow is described in this section." />

<a href="figures/Arrivals_Diagram.svg" target="_blank">Open the Arrivals diagram in a new tab.</a>

1. An IE007 arrival notification message is sent by the user to NCTS.
2. One of the following actions takes place:
   - NCTS sends the user an IE008 arrival notification rejection. (Go to step 1.)
   - NCTS sends an IE043 unloading permission message. (Go to step 3.)
   - NCTS sends an IE025 good release notification message. (Go to step 6.)
3. An IE043 unloading permission message results in one of the following actions:
   - An IE044 unloading remarks message is sent by the user to NCTS. (Go to step 4.)
   - If manual helpdesk intervention takes place, NCTS sends an IE025 goods release notification message. (Go to step 6.)
4. After NCTS receives an IE044 unloading remarks message, one of the following actions takes place:
   - NCTS sends an IE058 unloading remarks rejection message. (Go to step 5.)
   - NCTS sends an IE025 goods release notification message. (Go to step 6.)
   - If manual helpdesk intervention takes place, NCTS sends an IE043 unloading permission message. (Go to step 3.)
5. After NCTS sends an IE058 unloading remarks rejection message, one of the following actions takes place:
   - An IE044 unloading remarks message is sent by the user to NCTS. (Go to step 4.)
   - If manual Border Force intervention takes place, NCTS sends an IE043 unloading permission message. (Go to step 3.)
6. After NCTS sends an IE025 goods release notification message, NCTS sends an IE045 to the office of departure for the transit movement.

## NCTS Message Details

### XSD - XML Schema Definition
The API uses XSD templates to validate all the Information Exchange (IE) messages that come into the system.

If there are any problems, the IE message will be rejected with a 400 BadRequest status which will contain an explanation of the problem.

### Information Exchange messages
These are standard messages sent to and received from NCTS.

Details of the IE messages valid for use in the CTC Traders API are available in the TIS.

## API features

### Default Guarantee  Insertion

Our system will automatically insert a default guarantee amount of 10,000 Euros for any transit movement where the trader has not specified a guarantee value.

### Rate limits

Our API Platform’s standard rate limit is [3 requests per second](https://developer.service.hmrc.gov.uk/api-documentation/docs/reference-guide#rate-limiting). If you need a higher rate limit, you must give us more information about data and limit forecasts when filling in the [Application for Production Credentials checklist](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/figures/CTC_Traders_API_Application_for_Productions_Credentials.docx) form.

### Data cap and using filters

When you submit a request to 'GET all movements' against a single EORI enrolment, we’ll limit the number of movements you get back to 5,000.

This affects the ‘[GET all movements arrivals](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/1.0#_get-all-movement-arrivals_get_accordion)’ and ‘[GET all movement departure](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/1.0#_get-all-movement-departures_get_accordion)’ endpoints (remove links) More information can be viewed on our API CTC Traders documentation page (check APi definition -link to RAML).

You can use filters so that you only get the movements that have been updated since a specified date and time.

You can use the updatedSince parameter in order to retrieve new messages since you last polled. 
 
If you do not use filters:

 - you’ll only get up to the most recently updated 5,000 movements, within the last 28 days
 - you will not get any additional movements above this cap, within the last 28 days
 
In order to manage the limit you need to regularly poll using a filter date and time of the last poll. This will ensure your list of movements requested is less than 5,000.

You must also note:

 - the amount of responses that we send back to you will be capped at 5,000 for one single Economic Operator Registration and Identification (EORI) enrolment
 - the EORI enrolment for your application might not be the same as the trader’s EORI associated with a movement
 - the cap is not related to the movement EORI in the XML message
 - if your movements are split over multiple EORI enrolments then each enrolment will have a separate 5,000 cap
 - if you do get results over the 5,000 capped limit, the JSON payload will tell you this cap has happened and how many movements have not been sent to you. For example, the JSON message will state that 5,000 movements of a total of 6,433
 - only the most recent 5,000 data movements in the last 28 days will be returned. This is because we only store message data from the last 28 days
 
### Push pull notifications

Our automated service can send you notification updates about new messages from NCTS. This functionality will send you a notification each time there is a new message for you to read.

This means your:

 - software will not have to poll for updated information
 - requests are unlikely to be rate limited because they’ll not be as frequent
 - network usage will also go down because you’ll not need to poll
 
You should also note:

 - smaller messages of less than 100KB will be sent to you directly by our system in the payload of the push notification
 - messages greater than or equal to 100KB will not include the XML in the push notification
 - the push notification will have a field called messageURI which will contain the relative path to the full XML message
 - for messages larger than 100KB you must use the URI to download the XML message from the CTC Traders API
 
For more information on how to configure and test this functionality follow the step by step instructions in our [Guide to Testing](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/).

## Get Support

Before you get in touch, find out if there are any planned API downtime or technical issues by checking:

 - [HMRC API Platform availability](https://api-platform-status.production.tax.service.gov.uk/)
 - [NCTS service availability](https://www.gov.uk/government/publications/new-computerised-transit-system-ncts-web-service-availability-and-issues/new-computerised-transit-system-ncts-web-service-availability-and-issues)

If you have specific questions about the CTC Traders API, get in touch with our Software Developer Support Team.

You’ll get an initial response in 2 working days.

Email us your questions to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). We might ask for more detailed information when we respond.

**Useful Links**

 - [CTC Traders API roadmap](https://developer.service.hmrc.gov.uk/roadmaps/common-transit-convention-traders-roadmap/#phase-5)
 - [CTC Traders API phase 5 specification](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/common-transit-convention-traders/2.0)
 - [CTC Traders API phase 5 testing guide](https://developer.service.hmrc.gov.uk/guides/common-transit-convention-traders-testing-guide/)