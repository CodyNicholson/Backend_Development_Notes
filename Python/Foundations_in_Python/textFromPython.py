from twilio.rest import TwilioRestClient

account_sid = "ACa5225c6c505bb68357eda3522c8aa6f9" # Your Account SID from www.twilio.com/console
auth_token  = "ed50522bef403f966ecb24c8369f76dd"  # Your Auth Token from www.twilio.com/console

client = TwilioRestClient(account_sid, auth_token)

message = client.messages.create(
    body="ASDF",
    to="+1234567890",    # Replace with your phone number
    from_="+18565170270") # Replace with your Twilio number

print(message.sid)
