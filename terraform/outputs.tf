output "instance_public_ip" {
  description = "Public IP of the InsureMe EC2 instance"
  value       = aws_instance.insureme_instance.public_ip
}

output "instance_id" {
  description = "EC2 instance ID"
  value       = aws_instance.insureme_instance.id
}

