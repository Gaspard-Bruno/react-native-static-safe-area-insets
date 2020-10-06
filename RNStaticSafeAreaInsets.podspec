require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "RNStaticSafeAreaInsets"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  RNStaticSafeAreaInsets
                   DESC
  s.homepage     = package["repository"]["baseUrl"]
  s.license      = package["license"]
  s.author       = { "author" => package["author"]["email"] }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "#{package["repository"]["baseUrl"]}.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m}"
  s.requires_arc = true

  s.dependency "React-Core"
end

